COMANDOS=clean compile run

all: $(COMANDOS)

compile: 
	make -C src compile
run:    
	make -C src run

clean:  
	echo Limpando diretorios...
	find . -name '*.class' -print0 | xargs --no-run-if-empty -0 rm 
	find . -name '*.tokens' -print0 | xargs --no-run-if-empty -0 rm 
	find . -name 'NPLLexer.java' -print0 | xargs --no-run-if-empty -0 rm 
	find . -name 'NPLParser.java' -print0 | xargs --no-run-if-empty -0 rm
	find . -name '*.jar' -print0 | xargs --no-run-if-empty -0 rm

