J = java
JC = javac
TARGET = .
LIB = '../src/:../lib/junit-4.13-beta-3.jar'
JFLAGS = -g -d $(TARGET) -cp $(LIB)


.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
	../Main.java \
	../src/Node.java \
	../src/Edge.java \
	../src/Graf.java \
	../src/UndirectedGraf.java \
	../src/ConnectedGraf.java \

default: classes

classes: $(CLASSES:.java=.class)

run:
	java Main

clean:
		rm *.class