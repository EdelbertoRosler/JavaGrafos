package JavaGrafos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoTAD {
    private LinkedList<Integer>[] adj; // lista de adjacencia
    int numVertices; //numero de vértices
    private boolean ehDirigido; //indica se é dígrafo


    public GrafoTAD(int numVertices, boolean ehDirigido){
        this.ehDirigido = ehDirigido;
        this.numVertices = numVertices;
        this.adj = new LinkedList[this.numVertices];//cria uma lista como otamanho do número d vértices
        for (int i = 0; i < this.numVertices; i++) {
            this.adj[i] = new LinkedList<>();//cria uma lista para cada índice do adj
        }
    }

    public void insereAresta(int v0, int v1){
        this.adj[v0].add(v1);//insere aresta do v0 para V1
        if (! this.ehDirigido){//se ñ for dirigido...
            this.adj[v1].add(v0);//insere aresta adicional no sentido contrário
        }
    }

    public void imprimeListaAdj(){
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i+":");
            for (int j = 0; j < this.adj[i].size(); j++) {
                System.out.print(" [" + this.adj[i].get(j) + "]");
            }
            System.out.println();
        }
   }

    public void percursoLargura(int vertInic){
        Queue<Integer> filaVert = new LinkedList(); //cria uma fila vazia
        boolean [] vetorMarcacao = new boolean[this.numVertices];//cria um array de boolean com o tamanho do numVertices
        Arrays.fill(vetorMarcacao, false);//inicializa todos elementos boolean: falso

        filaVert.offer(vertInic);//enfilera no filaVert o vertice inicial
        vetorMarcacao[vertInic] = true;
        while (! filaVert.isEmpty()){
            int vert = filaVert.poll();//desinfilera do filaVert e coloca no vert
            System.out.println(vert);

            for (int i = 0; i < this.adj[vert].size(); i++) {
                if (!vetorMarcacao[this.adj[vert].get(i)]){//se o valor do índece vert, na lista adj, ñ estiver marcado
                    filaVert.offer(this.adj[vert].get(i));//enfilera no filaVert o elemento da fila de adj
                    vetorMarcacao[this.adj[vert].get(i)] = true;//marca o valor q está no índice vert, na lista adj
                }
            }
        }
    }

    public void percursoProfundidade(int vertInic){
        Stack<Integer> pilhaVert = new Stack();//cria uma pilha vazia
        boolean [] vetorMarcacao = new boolean[this.numVertices];//cria um array de boolean com o tamanho do numVertices
        Arrays.fill(vetorMarcacao, false);//inicializa todos elementos boolean: falso

        pilhaVert.push(vertInic);//enpilha no pilhaVert o vertice inicial
        vetorMarcacao[vertInic] = true;
        while (! pilhaVert.isEmpty()){
            int vert = pilhaVert.pop();//desempilha do pilhaVert e coloca no vert
            System.out.println(vert);

            for (int i = 0; i < this.adj[vert].size(); i++) {
                if (!vetorMarcacao[this.adj[vert].get(i)]){//se o valor do índece vert, na lista adj, ñ estiver marcado
                    pilhaVert.push(this.adj[vert].get(i));//enpilha no pilhaVert o elemento da fila de adj
                    vetorMarcacao[this.adj[vert].get(i)] = true;//marca o valor q está no índice vert, na lista adj
                }
            }
        }

    }
}