import java.sql.Date;
import java.util.Objects;

public class Cliente{
    
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private int telefone;

    public Cliente(int id, String nome, String cpf, Date dataNascimento, int telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
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

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Cliente id(int id) {
        setId(id);
        return this;
    }

    public Cliente nome(String nome) {
        setNome(nome);
        return this;
    }

    public Cliente cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Cliente dataNascimento(Date dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

    public Cliente telefone(int telefone) {
        setTelefone(telefone);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNascimento, telefone);
    }

    @Override
    public String toString() {
        return "" +
            "\n id='" + getId() + "'" +
            "\n nome='" + getNome() + "'" +
            "\n cpf='" + getCpf() + "'" +
            "\n dataNascimento='" + getDataNascimento() + "'" +
            "\n telefone='" + getTelefone() + "'" +
            "\n";
    }
}
