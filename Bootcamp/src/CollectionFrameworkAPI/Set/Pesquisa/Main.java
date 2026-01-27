package Pesquisa;

    public class Main {
        public static void main(String[] args) {

            AgendaContatos agenda = new AgendaContatos();

            agenda.adicionarContato("Vic", 12312313);
            agenda.adicionarContato("Maria", 36563653);
            agenda.adicionarContato("Amanda", 645645656);
            agenda.adicionarContato("Anthonny", 234234234);

            agenda.exibirContatos();

            System.out.println(agenda.pesquisarPorNome("Vic"));
        }
    }


