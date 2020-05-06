package designpatterns.creational;

class Program {
    String a, b, c, d;

    private Program(ProgramBuilder pb) {
        this.a = pb.a;
        this.b = pb.b;
        this.c = pb.c;
        this.d = pb.d;
    }

    @Override
    public String toString(){
        return a+b+c+d;
    }

    static class ProgramBuilder {
        private final String a;
        private final String b;
        private String c;
        private String d;

        ProgramBuilder(String a, String b) {
            this.a = a;
            this.b = b;
        }

        ProgramBuilder setC(String c) {
            this.c = c;
            return this;
        }

        ProgramBuilder setD(String d) {
            this.d = d;
            return this;
        }

        Program build() {
            return new Program(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";

        Program p = new Program.ProgramBuilder(a, b).setC(c).setD(d).build();

        System.out.println(p);
    }
}
