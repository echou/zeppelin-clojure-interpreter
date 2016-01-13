ERROR_PREFIX = To use this Makefile, you need to

ifeq ($(shell which lein),)
$(error $(ERROR_PREFIX) have 'lein' installed)
exit 1
endif

ifeq ($(ZEPPELIN_HOME),)
$(error $(ERROR_PREFIX) define the ZEPPELIN_HOME env variable)
exit 1
endif

VERSION = $(subst ",,$(lastword $(shell head -1 project.clj)))
INTERP_DIR = $(ZEPPELIN_HOME)/interpreter/clj
JAR_FILE = target/clojureinterpreter-$(VERSION)-standalone.jar

clean:
	rm $(JAR_FILE)

$(JAR_FILE):
	@lein uberjar

install: $(JAR_FILE)
	mkdir -p $(INTERP_DIR)
	cp $(JAR_FILE) $(INTERP_DIR)
