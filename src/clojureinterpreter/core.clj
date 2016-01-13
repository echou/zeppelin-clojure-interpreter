(ns clojureinterpreter.core
  (:require [clojure.tools.nrepl.server :as repl-server]
            [clojure.tools.nrepl :as repl-client])
  (:import [org.apache.zeppelin.interpreter
              Interpreter
              InterpreterResult
              InterpreterResult$Code
              InterpreterContext])
  (:gen-class
   :methods [^:static [open [] Object]
             ^:static [close [Object] void]
             ^:static [interpret [Object String org.apache.zeppelin.interpreter.InterpreterContext] org.apache.zeppelin.interpreter.InterpreterResult]]))

(def nrepl-server (atom nil))

(defn make-server []
  (let [new-server (repl-server/start-server)
        port (:port new-server)
        transport (repl-client/connect :port port)
        timeout 1000]
    (repl-client/client transport timeout)))

(defn open []
  (swap! nrepl-server
         (fn [server?]
           (if server?
             server?
             (make-server))))
  (repl-client/client-session @nrepl-server))

(defn -open [] (open))

(defn close [connection]
  (.close connection))

(defn -close [connection]
  (close connection))

(defn ^InterpreterResult interpret
  [connection
   ^String cmd
   ^InterpreterContext context]

  (let [outputs (-> connection
                    (repl-client/message {:op "eval" :code cmd})
                    doall)

        result (->> outputs
                    (filter #(contains? % :value))
                    first
                    :value)]
    (InterpreterResult. InterpreterResult$Code/SUCCESS result)))

(defn ^InterpreterResult -interpret
  [connection
   ^String cmd
   ^InterpreterContext context]
  (interpret connection cmd context))
