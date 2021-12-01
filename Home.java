import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;


public class Home {
    public static void main(String[] args) {
        try{
           

            Scanner scan1 = new Scanner(System.in);
            int escolha= 0;
            int id_chef = 0;
            int id_cliente = 0;
            String nome = "";
            String cpf = "";
            String data_nasc = "";
            float salario = 0;
            int telefone = 0;


            //Menu bonitinho, seguido de um scanner onde o numero será ligado ao switch, cada switch é um comando SQL
            do{
            System.out.println("+--------------------------------+");
            System.out.println("|        CENTRO DE COMANDO       |");
            System.out.println("+--------------------------------+");
            System.out.println("| [1] ->     INSERT CHEF         |");
            System.out.println("| [2] ->     UPDATE CHEF         |");
            System.out.println("| [3] ->     DELETE CHEF         |");
            System.out.println("| [4] ->     SELECT CHEF         |");
            System.out.println("| [5] ->   INSERT CLIENTE        |");
            System.out.println("| [6] ->   UPDATE CLIENTE        |");
            System.out.println("| [7] ->   DELETE CLIENTE        |");
            System.out.println("| [8] ->   SELECT CLIENTE        |");
            System.out.println("| [9] ->        SAIR             |");
            System.out.println("+--------------------------------+");
            System.out.println(" Escolha uma opção: ");
            escolha = scan1.nextInt();

                switch(escolha){
                  

                    case 1:
            //Como dito no menu aqui é o insert, onde o Chef será criado, é inserido o valor pelo scanner para definir 
                    System.out.println("+---------------------+");
                    System.out.println("|   CRIAÇÃO DE CHEF   |");
                    System.out.println("+---------------------+");
                    System.out.println("ID: ");
                    try {
                        id_chef = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println("       CPF:        ");
                    try {
                        cpf = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println("DATA DE NASCIMENTO: ");
                    try {
                        data_nasc = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("--------------------");
                    System.out.println("    SALÁRIO:     ");
                    try {
                        salario = scan1.nextFloat();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    try {
                //Conexão com o banco de dados, seguido pelo seu comando, aqui é chamada o valor definido a cima para inserir aos banco
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);

                    
                    PreparedStatement state = con.prepareStatement("INSERT INTO chef (id_chef, nome, cpf, data_nasc, salario) VALUES (?,?,?,?,?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state.setInt(1,id_chef);
                    state.setString(2,nome);    
                    state.setString(3,cpf);
                    state.setString(4,data_nasc);
                    state.setFloat(5,salario);

                    if(state.executeUpdate()>0){
                        ResultSet resultado = state.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getFloat(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;
                    
                    case 2:

                    System.out.println("+-------------------+");
                    System.out.println("|  UPTADE DE DADOS  |");
                    System.out.println("+-------------------+");
                    System.out.println("ID: ");
                    try {
                        id_chef = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       CPF:        ");
                    try {
                        cpf = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("DATA DE NASCIMENTO: ");
                    try {
                        data_nasc = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("    SALÁRIO:       ");
                    try {
                        salario = scan1.nextFloat();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);

                    PreparedStatement state2 = con.prepareStatement("UPDATE chef SET nome = ?, cpf = ?, salario = ?, data_nasc = ? WHERE id_chef = ?", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state2.setString(1,nome);
                    state2.setString(2,cpf);
                    state2.setFloat(3,salario);
                    state2.setString(4,data_nasc);
                    state2.setInt(5,id_chef);
                     
                    if(state2.executeUpdate()>0){
                        ResultSet resultado = state2.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getString(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;


                    case 3:

                    System.out.println("+----------------+");
                    System.out.println("|  DELETAR CHEF  |");
                    System.out.println("+----------------+");
                    System.out.println("ID: ");
                    try {
                        id_chef = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state3 = con.prepareStatement("DELETE FROM chef WHERE id_chef = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS );
                    state3.setInt(1, id_chef);

                    if(state3.executeUpdate()>0){
                        ResultSet resultado = state3.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    
                    case 4:

                    System.out.println("+-------------------+");
                    System.out.println("|  SELECIONAR CHEF  |");
                    System.out.println("+-------------------+");
                    System.out.println("ID: ");
                    try {
                        id_chef = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state4 = con.prepareStatement("SELECT * FROM chef WHERE id_chef = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state4.setInt(1,id_chef);
                    ResultSet result = state4.executeQuery();
                    while(result.next()){
                        Chef chef = new Chef(
                            result.getInt("id_chef"),
                            result.getString("nome"),
                            result.getString("cpf"),
                            result.getDate("data_nasc"),
                            result.getFloat("salario")
                            );
                    System.out.println(chef);
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                   

                    case 5:
                    System.out.println("+----------------------+");
                    System.out.println("|  CRIAÇÃO DE CLIENTE  |");
                    System.out.println("+----------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente= scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       CPF:        ");
                    try {
                        cpf = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("DATA DE NASCIMENTO: ");
                    try {
                        data_nasc = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("    TELEFONE:      ");
                    try {
                        telefone = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);


                    PreparedStatement state = con.prepareStatement("INSERT INTO cliente (id_cliente, nome, cpf, data_nasc, telefone) VALUES (?,?,?,?,?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state.setInt(1,id_cliente);
                    state.setString(2,nome);
                    state.setString(3,cpf);
                    state.setString(4,data_nasc);
                    state.setInt(5,telefone);

                    if(state.executeUpdate()>0){
                        ResultSet resultado = state.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getInt(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 6:
                    System.out.println("+---------------------+");
                    System.out.println("|   UPTADE DE DADOS   |");
                    System.out.println("+---------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       NOME:       ");
                    try {
                        nome = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("       CPF:        ");
                    try {
                        cpf = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("DATA DE NASCIMENTO: ");
                    try {
                        data_nasc = scan1.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("-------------------");
                    System.out.println("    TELEFONE:    ");
                    try {
                        telefone = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);

                    PreparedStatement state2 = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, data_nasc = ? WHERE id_cliente = ?", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state2.setString(1,nome);
                    state2.setString(2,cpf);
                    state2.setFloat(3,telefone);
                    state2.setString(4,data_nasc);
                    state2.setInt(5,id_cliente);
                     
                    if(state2.executeUpdate()>0){
                        ResultSet resultado = state2.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                            resultado.getString(2);
                            resultado.getString(3);
                            resultado.getString(4);
                            resultado.getString(5);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 7:
                    System.out.println("+--------------------+");
                    System.out.println("|   DELETAR CLIENTE  |");
                    System.out.println("+--------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state3 = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS );
                    state3.setInt(1, id_cliente);

                    if(state3.executeUpdate()>0){
                        ResultSet resultado = state3.getGeneratedKeys();

                        if(resultado.next()){
                            resultado.getInt(1);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 8:
                    System.out.println("+----------------------+");
                    System.out.println("|  SELECIONAR CLIENTE  |");
                    System.out.println("+----------------------+");
                    System.out.println("ID: ");
                    try {
                        id_cliente = scan1.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/provajava?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement state4 = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS);
                    state4.setInt(1,id_cliente);
                    ResultSet result = state4.executeQuery();
                    while(result.next()){
                        Cliente cliente = new Cliente(
                            result.getInt("id_cliente"),
                            result.getString("nome"),
                            result.getString("cpf"),
                            result.getDate("data_nasc"),
                            result.getInt("telefone")
                            );
                    System.out.println(cliente);
                    }
                    con.close();
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
                    break;

                    case 9:
                    System.out.println("\n Obrigado por usar o programa! :D ");
                    System.out.println(" TCHAU TCHAU \n");
                    break;

                }

                }while(escolha != 9);
                scan1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}