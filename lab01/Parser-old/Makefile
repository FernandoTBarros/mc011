include Makefile.inc
#export CLASSPATH=".:'./lib/antlr-4.0-complete.jar':$(CLASSPATH)"

VPATH=src
COMANDOS=clean compile run
EXECUTOR=NPLReader
OBJSLIB=antlr-4.0-complete.jar
OBJSGEN=src/br/npl/NPLLexer.g4 src/br/npl/NPLParser.g4
OBJSLD=src/br/npl/NPL*.java
OBJSRM= *.class NPL*.tokens NPLLexer.java NPLParser.java
all: $(COMANDOS)

$(OBJSLIB):
	$(ECHO) Baixando lib...
	wget http://antlr4.org/download/antlr-4.0-complete.jar

compile: $(OBJSLIB) 
	$(ECHO) Compilando...
	#$(ECHO) $(RUNNER) -$(RUNNERFLAGS) $(OBJSGEN)
	$(RUNNER) -$(RUNNERFLAGS) -$(ANTLRFLAGS_LISTENER) -$(ANTLRFLAGS_VISITOR) $(OBJSGEN)
	$(ECHO) $(LD) $(OBJSLD)       	
	$(LD) $(OBJSLD)

run:    force_look 
	$(ECHO) Executando...
	$(ECHO) $(RUNNER) $(EXECUTOR) $(INPUT) $(OUTPUT)
	$(RUNNER) $(EXECUTOR) $(INPUT) $(OUTPUT) 

clean:  force_look 
	$(ECHO) Limpando diretorio...
	$(ECHO) $(RM) -$(RMRF) $(OBJSRM)
	find . -name '*.class' -print0 | xargs --no-run-if-empty -0 rm 
	find . -name 'NPL*.tokens' -print0 | xargs --no-run-if-empty -0 rm 
	find . -name 'NPLLexer.java' -print0 | xargs --no-run-if-empty -0 rm 
	find . -name 'NPLParser.java' -print0 | xargs --no-run-if-empty -0 rm 
#	$(RM) -$(RMRF) $(OBJSRM)

force_look: 
	true
