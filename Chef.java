import java.sql.Date;
import java.util.Objects;

public class Chef {
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Float salario;

    public Chef(int id, String nome, String cpf, Date dataNascimento, Float salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario= salario;
    }

    public Chef id(int id) {
        setId(id);
        return this;
    }

    public Chef nome(String nome) {
        setNome(nome);
        return this;
    }

    public Chef cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Chef dataNascimento(Date dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

    public Chef salario(float salario) {
        setSalario(salario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chef)) {
            return false;
        }
     Chef chef = (Chef) o;
        return id == chef.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNascimento, salario);
    }

    @Override
    public String toString() {
        return "" +
            "\n  id:'" + getId() + "'" +
            "\n  nome:'" + getNome() + "'" +
            "\n  cpf:'" + getCpf() + "'" +
            "\n  dataNascimento:'" + getDataNascimento() + "'" +
            "\n  Salario:'" + getSalario() + "'" +
                "\n";
    }
}
