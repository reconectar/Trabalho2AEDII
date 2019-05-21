
public class app {

	public static void main(String[] args) {
		CArvBin arvore = new CArvBin();
		arvore.put(27, "teste1");
		arvore.put(32, "teste2");
		arvore.put(13, "teste3");
		arvore.put(5, "teste4");
		arvore.put(14, "teste5");
		arvore.put(3, "teste6");
		arvore.put(6, "teste7");
//		System.out.println("Quantidade de nos: " + (arvore.qtdeNosFolha() + arvore.qtdeNosInternos()));
//		System.out.println("Menor da subarvore de chave 27 = " + arvore.menorNoSubArvore(27));
//		System.out.println("Altura da subarvore de chave 27 = " + arvore.alturaNo(27));
//		System.out.println("Profundidade nó 27: " + arvore.profundidade(27));
//		System.out.println(arvore.imprimeNosFolha());	
		arvore.informacoes();
	}
}
