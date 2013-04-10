LD=javac
RUNNER=java
RUNNERFLAGS=jar
ANTLRFLAGS_LISTENER=no-listener
ANTLRFLAGS_VISITOR=no-visitor
LDFLAGS=cp
RM=rm 
RMRF=rf
ECHO=echo
SHELL=/bin/sh
.SILENT :

COMANDOS=compile run
EXECUTOR=NPLReader
OBJSLIB=antlr-4.0-complete.jar
OBJSGEN=NPLLexer.g4 NPLParser.g4
OBJSLD=*.java

all: $(COMANDOS)

$(OBJSLIB):
	$(ECHO) Baixando lib...
	wget http://antlr4.org/download/antlr-4.0-complete.jar

compile: $(OBJSLIB) 
	$(ECHO) Compilando...
	$(ECHO) $(RUNNER) -$(RUNNERFLAGS) $(OBJSLIB) -$(ANTLRFLAGS_LISTENER) -$(ANTLRFLAGS_VISITOR) $(OBJSGEN)
	$(RUNNER) -$(RUNNERFLAGS) $(OBJSLIB) -$(ANTLRFLAGS_LISTENER) -$(ANTLRFLAGS_VISITOR) $(OBJSGEN)
	$(ECHO) $(LD) -$(LDFLAGS) $(OBJSLIB) $(OBJSLD)
	$(LD) -$(LDFLAGS) $(OBJSLIB) $(OBJSLD)

run:    
	$(ECHO) Executando...
	$(ECHO) $(RUNNER) $(EXECUTOR) $(INPUT) $(OUTPUT)
	$(RUNNER) -$(LDFLAGS) $(OBJSLIB):. $(EXECUTOR) ../$(INPUT) ../$(OUTPUT) 

