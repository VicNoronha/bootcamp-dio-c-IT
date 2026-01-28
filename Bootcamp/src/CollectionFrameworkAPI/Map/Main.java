package Map;

public class Main {
    public static void main (String [] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Camila" ,786786);
        agendaContatos.adicionarContato("Maria" ,474657);
        agendaContatos.adicionarContato("Vanessa" ,674674);
        agendaContatos.adicionarContato("Elisa" ,567567);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Maria");
        agendaContatos.exibirContatos();




    }
}
