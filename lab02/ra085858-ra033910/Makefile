all: clean compile
	@echo ""

clean:
	rm src/x86/*.class

compile:
	javac -classpath lib/etapa2.jar src/x86/*.java 

run:
	java -classpath src:lib/etapa2.jar main/Main $(INPUT) $(OUTPUT)

compile_assembly:
	nasm -felf32 $(INPUT) -o saida.o
	gcc -m32 saida.o lib/runtime.o -o $(OUTPUT)
