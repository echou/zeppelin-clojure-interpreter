(defproject clojureinterpreter "0.1.1"
  :description "A Clojure Interpreter for Zeppelin Notebooks"
  :url "https://github.com/bfabry/zeppelin-clojure-interpreter"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.apache.zeppelin/zeppelin-interpreter "0.5.0-incubating"]
                 [org.clojure/tools.nrepl "0.2.11"]]
  :prep-tasks [["compile" "clojureinterpreter.core"]
               "javac"
               "compile"]
  :java-source-paths ["src-java"])


