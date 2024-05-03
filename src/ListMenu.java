import java.util.*;

public class ListMenu {

    public interface Handler {
        public void execute();
    }

    public interface PreCondition {
        public boolean validate();
    }

    private static Scanner is = new Scanner(System.in);

    private List<String> opcoes;
    private List<PreCondition> disponivel;
    private List<Handler> handlers;
    private List<Integer> endOptions;
    private boolean runOnce;
    private String title;

    public ListMenu(String[] opcoes, boolean runOnce) {
        this.title = "NewMenu";
        this.opcoes = Arrays.asList(opcoes);
        this.disponivel = new ArrayList<>();
        this.handlers = new ArrayList<>();
        this.endOptions = new ArrayList<>();
        this.runOnce = runOnce;
        this.opcoes.forEach(s -> {
            this.disponivel.add(() -> true);
            this.handlers.add(() -> System.out.println("\nATTENTION: Option not implemented!"));
        });
    }

    public void run() {
        int op;
        do {
            show();
            op = readOption();
            if (op == 0) {
                System.out.println("Exiting...");
                System.exit(0); // Exit the program
            } else if (op > 0 && op <= this.opcoes.size() && this.disponivel.get(op - 1).validate()) {
                this.handlers.get(op - 1).execute();
                if (endOptions.contains(op)) { // Check if the option should end the menu
                    break;
                }
            } else {
                System.out.println("Option not available! Try again.");
            }
        } while (!runOnce && op != 0);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEndOptions(Integer... options) {
        this.endOptions = Arrays.asList(options);
    }

    public void setPreCondition(int i, PreCondition b) {
        this.disponivel.set(i - 1, b);
    }

    public void setHandler(int i, Handler h) {
        this.handlers.set(i - 1, h);
    }

    private void show() {
        System.out.println("\n *** " + title + " *** ");
        for (int i = 0; i < this.opcoes.size(); i++) {
            System.out.print(i + 1);
            System.out.print(" - ");
            System.out.println(this.disponivel.get(i).validate() ? this.opcoes.get(i) : "---");
        }
        System.out.println("0 - Exit the application");
    }

    private int readOption() {
        int op;

        System.out.print("Option: ");
        try {
            String line = is.nextLine();
            op = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            op = -1;
        }
        if (op < 0 || op > this.opcoes.size()) {
            // System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }
}
