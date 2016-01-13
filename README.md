# clj Zeppelin

[![][clj-zep-logo]][clj-zep-logo-large]

[clj-zep-logo]: resources/images/clojurezeppelin-logo-x250.png
[clj-zep-logo-large]: resources/images/clojurezeppelin-logo-x1000.png

*A Clojure Interpreter for Zeppelin Notebooks*


#### Contents

* [Introduction](#introduction-)
* [Dependencies](#dependencies-)
* [Installation](#build--installation-)
* [Configuration](#configuration-)


## Introduction [&#x219F;](#contents)

TBD


## Dependencies [&#x219F;](#contents)

* Zeppelin
* ``lein``

Optional:

* GNU ``make``


## Installation [&#x219F;](#contents)

### Auto Build & Install

Simply execute the following make target:

```bash
$ make install
```

### Manual Build & Install

When the automatic approach is not preferred, you may perform the steps
manually:

```bash
$ lein uberjar
```

This will create the file ``target/clojureinterpreter-0.2.0-standalone.jar``.
Copy this to the ``interpreter`` directory in your ``ZEPPELIN_HOME``, e.g.:

```bash
$ mkdir /opt/zeppelin/0.5.5/interpreter/clj/
$ cp target/clojureinterpreter-0.2.0-standalone.jar /opt/zeppelin/0.5.5/interpreter
```


## Configuration [&#x219F;](#contents)

Once the Clojure interpreter ``.jar`` file is in place, you'll need to
configure Zeppelin to let it know it's available for use. In setting up
Zeppelin, you should have created (or it was created for you) the configuration
file ``$ZEPPELIN_HOME/conf/zeppelin-site.xml``.

1. Open ``$ZEPPELIN_HOME/conf/zeppelin-site.xml``
1. Search for the line ``<name>zeppelin.interpreters</name>``
1. After the last interpreter given in the ``<value>`` tag, add a comma and
   then the value ``clojureinterpreter.ClojureInterpreter``; if you want
   Clojure to be your default interpreter, move it to the first value in the
   comma-separatede list of values
1. Save and exit the file
1. Restart Zeppelin, e.g.: ``/opt/zeppelin/0.5.5/bin/zeppelin-daemon.sh restart``
1. Load up the Zeppelin in your browser and enjoy Clojure :-)

