# clj Zeppelin

[![][clj-zep-logo]][clj-zep-logo-large]

[clj-zep-logo]: resources/images/clojurezeppelin-logo-x250.png
[clj-zep-logo-large]: resources/images/clojurezeppelin-logo-x1000.png

*A Clojure Interpreter for Zeppelin Notebooks*

## Versions

There are two versions supported, both in separate branches:

* [Zeppelin 0.5.0](../../tree/Zeppelin-0.5.0)
  * This is the original code (with a few slight modifications) for the Zeppelin Clojure interpreter by [Beau Fabry](https://github.com/bfabry)
  * Changes include intructions in a README, a ``Makefile`` for easy installation, minor formatting tweaks, etc.
* [Zeppelin 0.5.5](../../tree/Zeppelin-0.5.5)
  * Uses the latest binary release of Zeppelin
  * Uses the binary release's ``zeppelin-interpreter.jar``, since there is no official 0.5.5 jar on Maven or Clojars
  * Includes two popular Clojure libraries for Spark: [flambo](https://github.com/yieldbot/flambo) and [sparkling](https://github.com/gorillalabs/sparkling)
  * [Spark GraphX](http://spark.apache.org/graphx/)
* [Zeppelin 0.5.5-ML](../../tree/Zeppelin-0.5.5-ML)
  * Includes everything in Zeppelin 0.5.5 plus:
  * [Spark MLlib](http://spark.apache.org/docs/latest/mllib-guide.html) (machine learning)
