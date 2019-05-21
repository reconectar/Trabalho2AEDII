public class CArvBin {

	class CNo {
		private int chave;
		private Object valor;
		private CNo esq, dir;

		public CNo() {
			valor = esq = dir = null;
		}

		public CNo(int k) {
			chave = k;
			valor = esq = dir = null;
		}

		public CNo(int k, Object v) {
			chave = k;
			valor = v;
			esq = null;
			dir = null;
		}

		public CNo(int k, Object v, CNo e, CNo d) {
			chave = k;
			valor = v;
			esq = e;
			dir = d;
		}
	}

	private CNo raiz = null;

	public Object get(int k) {
		return get(raiz, k);
	}

	private Object get(CNo no, int k) {
		if (no == null)
			return null;
		if (k < no.chave)
			return get(no.esq, k);
		else if (k > no.chave)
			return get(no.dir, k);
		else
			return no.valor;
	}

	public void put(int k, Object v) {
		raiz = put(raiz, k, v);
	}

	private CNo put(CNo no, int k, Object v) {
		if (no == null)
			return new CNo(k, v);
		if (k < no.chave)
			no.esq = put(no.esq, k, v);
		else if (k > no.chave)
			no.dir = put(no.dir, k, v);
		else
			no.valor = v;
		return no;
	}

	private void emOrdem(CNo no) {
		if (no != null) {
			emOrdem(no.esq);
			System.out.println(no.chave + " " + no.valor);
			emOrdem(no.dir);
		}
	}

	private void preOrdem(CNo no) {
		if (no != null) {
			System.out.println(no.chave + " " + no.valor);
			preOrdem(no.esq);
			preOrdem(no.dir);
		}
	}

	private void posOrdem(CNo no) {
		if (no != null) {
			posOrdem(no.esq);
			posOrdem(no.dir);
			System.out.println(no.chave + " " + no.valor);
		}
	}

	public void imprimeABP(int op) {
		if (op == 1)
			preOrdem(raiz);
		else if (op == 2)
			emOrdem(raiz);
		else if (op == 3)
			posOrdem(raiz);
		else
			System.out.println("Opção de impressão inválida.");
	}

	private int somaNosInt(CNo no) {
		if (no != null && (no.dir != null || no.esq != null))
			return no.chave + somaNosInt(no.esq) + somaNosInt(no.dir);
		else
			return 0;
	}

	public int somaNosInt() {
		return somaNosInt(raiz);
	}

	// Realiza a contagem de nos a partir de um dado no
	private int contaNos(CNo no) {
		if (no != null)
			return 1 + contaNos(no.esq) + contaNos(no.dir);
		else
			return 0;
	}

	// Chama o metodo ContaNos passando a raiz como no inicial
	public int contaNos() {
		return contaNos(raiz);
	}

	// Realiza a contagem de nos folhas a partir de determinado no
	private int qtdeNosFolha(CNo no) {
		if (no != null) {
			int incremento = 0;
			if (no.esq == null && no.dir == null)
				incremento++;
			return incremento + qtdeNosFolha(no.dir) + qtdeNosFolha(no.esq);
		} else
			return 0;
	}

	// Chama o metodo QtdeNosFolha passando a raiz como no inicial
	public int qtdeNosFolha() {
		return qtdeNosFolha(raiz);
	}

	// Realiza a contagem de nos internos a partir de determinado no
	private int qtdeNosInternos(CNo no) {
		if (no != null) {
			int incremento = 0;
			if (no.esq != null || no.dir != null)
				incremento++;
			return incremento + qtdeNosInternos(no.dir) + qtdeNosInternos(no.esq);
		} else
			return 0;
	}

	// Chama o metodo QtdeNosInternos passando a raiz como no inicial
	public int qtdeNosInternos() {
		return qtdeNosInternos(raiz);
	}

	// Imprime os nos folha no percurso em ordem
	private void imprimeNosFolhaEmOrdem(CNo no) {
		if (no != null) {
			imprimeNosFolhaEmOrdem(no.esq);
			if (no.esq == null && no.dir == null) {
				System.out.println(no.valor);
			}
			imprimeNosFolhaEmOrdem(no.dir);
		}
	}

	// Chama o metodo ImprimeNosFolhaEmOrdem passando a raiz como parametro
	public void imprimeNosFolhaEmOrdem() {
		imprimeNosFolhaEmOrdem(raiz);
	}

	// Imprime os nos folha no percurso em ordem
	private void imprimeNosInternosEmOrdem(CNo no) {
		if (no != null) {
			imprimeNosInternosEmOrdem(no.esq);
			if (no.esq != null || no.dir != null)
				System.out.println(no.valor);
			imprimeNosInternosEmOrdem(no.dir);
		}
	}

	// Chama o metodo ImprimeNosFolhaEmOrdem passando a raiz como parametro
	public void imprimeNosInternosEmOrdem() {
		imprimeNosInternosEmOrdem(raiz);
	}

	// Chama o metodo ImprimeNosFolhaEmOrdem passando a raiz como parametro
	public void ImprimeNosInternosEmOrdem() {
		imprimeNosInternosEmOrdem(raiz);
	}

	public void imprimeInformacoesNos() {
		imprimeInformacoesNos(raiz);
	}

	private void imprimeInformacoesNos(CNo no) {
		if (no != null) {
			System.out.println("Nó " + no.valor);
			int filhos = 0;
			Object filhoEsq, filhoDir;
			if (no.esq != null) {
				filhos++;
				filhoEsq = no.esq.valor;
			} else
				filhoEsq = null;
			if (no.dir != null) {
				filhos++;
				filhoDir = no.dir.valor;
			} else
				filhoDir = null;

			System.out.println("  Qtde. Filhos: " + filhos);
			System.out.println("  Filho esquerda: " + filhoEsq);
			System.out.println("  Filho direita: " + filhoDir);
			System.out
					.println("  Nó interno ou folha? " + (filhoEsq == null && filhoDir == null ? "Folha" : "Interno"));
			System.out.println();
			System.out.println();

			imprimeInformacoesNos(no.esq);
			imprimeInformacoesNos(no.dir);
		}
	}

	// Metodo suporte
	private CNo noSubArvore(CNo no, int k) {
		CNo auxSubArvore = no;
		while (auxSubArvore.chave != k) {
			if (k < auxSubArvore.chave) {
				auxSubArvore = auxSubArvore.esq;
			} else {
				auxSubArvore = auxSubArvore.dir;
			}
		}
		return auxSubArvore;
	}

	// Q2a Recursivo maior nó (2 metodos)
	public Object maiorNo() {
		if (raiz != null)
			return maiorNo(raiz);
		else
			return -1;
	}

	private Object maiorNo(CNo no) {
		if (no.dir != null)
			return maiorNo(no.dir);
		else
			return no.valor;
	}

	// Q2a Recursivo menor nó (2 metodos)
	private Object menorNo(CNo no) {
		if (no.esq != null)
			return menorNo(no.esq);
		else
			return no.valor;
	}

	public Object menorNo() {
		if (raiz != null)
			return menorNo(raiz);
		else
			return -1;
	}

	// Q2b Menor nó subárvore
	public Object menorNoSubArvore(int k) {
		return menorNo(noSubArvore(raiz, k));
	}

	public Object maiorNoSubArvore(int k) {
		return maiorNo(noSubArvore(raiz, k));
	}

	// Q2c Altura nó
	private int alturaNo(CNo auxNo) {
		if (auxNo == null) {
			return 0;
		}
		int alturaEsquerda = alturaNo(auxNo.esq);
		int alturaDireita = alturaNo(auxNo.dir);

		if (alturaEsquerda > alturaDireita) {
			return alturaEsquerda + 1;
		} else {
			return alturaDireita + 1;
		}
	}

	public int alturaNo(int k) {
		return alturaNo(noSubArvore(raiz, k));
	}

	// Q2d Profundidade nó
	private int profundidadeRec(CNo no, int k, int profundidade) {
		if (no == null) {
			return 1;
		}
		if (no.chave == k) {
			return profundidade;
		}

		int level = profundidadeRec(no.esq, k, profundidade + 1);
		if (level != 1) {
			return level;
		}
		level = profundidadeRec(no.dir, k, profundidade + 1);
		return level;
	}

	public int profundidade(int k) {
		return profundidadeRec(raiz, k, 1);
	}

	// Q2g
	public CNo referencia(int k) {
		return noSubArvore(raiz, k);
	}

	// Q2j
	private void informacoes(CNo no, int pai) {
		if (no != raiz) {
			System.out.println("Pai: " + pai);
			pai = no.chave;
		}
		System.out.println("Valor: " + "(" + no.chave + ")" + " = " + no.valor);
		System.out.println("Altura: " + alturaNo(no));
		System.out.println("Profundidade: " + profundidade(no.chave));
		int qtdeFilhos = 0;
		if (no.esq != null && no.dir != null) {
			qtdeFilhos = 2;
			System.out.println("Quantidade de filhos = " + qtdeFilhos);
			System.out.print("Filho esq = " + no.esq.valor.toString());
			System.out.print(", filho dir = " + no.dir.valor.toString() + System.lineSeparator());
			if (no != raiz) {
				System.out.println("Nó intermediario!");
			}
		} else if (no.esq != null && no.dir == null) {
			qtdeFilhos = 1;
			System.out.println("Quantidade de filhos = " + qtdeFilhos);
			System.out.println("Filho esq = " + no.esq.valor.toString());
			System.out.println("Nó intermediario!");
		} else if (no.esq == null && no.dir != null) {
			qtdeFilhos = 1;
			System.out.println("Quantidade de filhos = " + qtdeFilhos);
			System.out.println("Filho dir = " + no.dir.valor.toString());
			System.out.println("Nó intermediario!");
		} else {
			System.out.println("Nó folha!");
		}
		System.out.println();
		if (no.esq != null) {
			informacoes(no.esq, pai);
		}
		if (no.dir != null) {
			informacoes(no.dir, pai);
		}
	}

	public void informacoes() {
		informacoes(raiz, raiz.chave);
	}

	// Q2k
	private String imprimeNosFolha(CNo no) {
		if (no != null) {
			String folhas = "";
			if (no.esq == null && no.dir == null)
				folhas += no.valor.toString();
			return folhas + imprimeNosFolha(no.dir) + " " + imprimeNosFolha(no.esq);
		} else
			return "";
	}

	// Chama o metodo QtdeNosFolha passando a raiz como no inicial
	public String imprimeNosFolha() {
		return "Folhas: " + imprimeNosFolha(raiz);
	}

	public boolean achou(int k) {
		return achouRec(raiz, k);
	}

	private boolean achouRec(CNo no, int k) {
		if (no != null && no.chave != k) {
			if (k < no.chave)
				return achouRec(no.esq, k);
			else
				return achouRec(no.dir, k);
		}
		return no != null ? true : false;
	}

}