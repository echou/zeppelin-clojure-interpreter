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
LOCAL_JARS = ./resources
JAR_FILE = target/clojureinterpreter-$(VERSION)-standalone.jar

$(JAR_FILE):
	cp $(ZEPPELIN_HOME)/lib/*.jar $(LOCAL_JARS)/
	@lein uberjar

clean:
	rm $(JAR_FILE)

install: $(JAR_FILE)
	mkdir -p $(INTERP_DIR)
	cp $(JAR_FILE) $(INTERP_DIR)
