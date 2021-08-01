package JavaGrafos;

public class Principal {
    public static void main(String[] args) {
        GrafoTAD grafo = new GrafoTAD(8, false);//grafo de 6 vértices não dirigido
        GrafoTAD grafo2 = new GrafoTAD(6, true);//dígrafo de 7 arestas

//        grafo.insereAresta(0, 1);
//        grafo.insereAresta(1, 5);
//        grafo.insereAresta(5, 2);
//        grafo.insereAresta(2, 1);
//        grafo.insereAresta(2, 3);
//        grafo.insereAresta(3, 4);
//        grafo.insereAresta(2, 4);
//        grafo.insereAresta(2, 6);
//        grafo.insereAresta(6, 7);
//
//        grafo.imprimeListaAdj();
////        grafo.percursoLargura(0);
//        grafo.percursoProfundidade(0);

        grafo2.insereAresta(0, 2);
        grafo2.insereAresta(1, 2);
        grafo2.insereAresta(1, 4);
        grafo2.insereAresta(2, 4);
        grafo2.insereAresta(3, 2);
        grafo2.insereAresta(3, 5);
        grafo2.insereAresta(5, 4);

        grafo2.imprimeListaAdj();
//        grafo2.percursoLargura(0);
        grafo2.percursoProfundidade(0);
    }
}
