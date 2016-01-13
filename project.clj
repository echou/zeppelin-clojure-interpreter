(defproject clojureinterpreter "0.2.1"
  :description "A Clojure Interpreter for Zeppelin Notebooks"
  :url "https://github.com/bfabry/zeppelin-clojure-interpreter"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.nrepl "0.2.11"]
                 [ch.qos.logback/logback-classic "1.1.3"]
                 [yieldbot/flambo "0.7.1"]
                 [gorillalabs/sparkling "1.2.3"]]
  :resource-paths ["resources/zeppelin-interpreter-0.5.5-incubating.jar"]
  :prep-tasks [["compile" "clojureinterpreter.core"]
               "javac"
               "compile"]
  :java-source-paths ["src-java"])


