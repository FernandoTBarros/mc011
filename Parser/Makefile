include Makefile.inc
export CLASSPATH="antlr-4.0-complete.jar:$CLASSPATH"

COMANDOS=clean compile run
EXECUTOR=NPLReader
OBJSLIB=lib/antlr-4.0-complete.jar
OBJSGEN=NPLParser.g4 NPLLexer.g4
OBJSLD=NPL*.java NPLReader.java
OBJSRM= *.class NPL*.tokens NPLLexer.java NPLParser.java
all: $(COMANDOS)

compile: force_look 
	$(ECHO) Compilando...
	$(ECHO) $(RUNNER) $(RUNNERFLAG) $(OBJSLIB) $(OBJSGEN)
	$(RUNNER) -$(RUNNERFLAGS) $(OBJSLIB) $(OBJSGEN)
	$(ECHO) $(LD) $(OBJSLD)       	
	$(LD) $(OBJSLD)

run:    force_look 
	$(ECHO) Executando...
	$(ECHO) $(RUNNER) $(EXECUTOR) $(INPUT) $(OUTPUT)
	$(RUNNER) $(EXECUTOR) $(INPUT) $(OUTPUT) 

clean:  force_look 
	$(ECHO) Limpando diretorio...
	$(ECHO) $(RM) -$(RMRF) $(OBJSRM)
	$(RM) -$(RMRF) $(OBJSRM)

force_look: 
	true
