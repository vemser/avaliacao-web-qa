package br.com.dbcompany.vemser.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import br.com.caelum.stella.format.CPFFormatter;

public class DataFakerGenerator {

    private static final Faker faker = new Faker(new Locale("pt-BR"));
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static Random random = new Random();

    public static String emailFaker() {
        return "teste." + faker.internet().emailAddress();
    }
    public static String emailDbcFaker() {
        String emailPessoal = emailFaker();
        return emailPessoal.replace(emailPessoal.substring(emailPessoal.indexOf("@"), emailPessoal.length()), "@dbccompany.com.br");
    }
    public static String observacoesFaker() {
        return faker.lorem().sentence();
    }
    public static String linkedinFaker() {
        return "https://teste.linkedin.com/in/" + faker.numerify("###########") + "/";
    }
    public static String gitHubFaker() {
        return "https://teste.github.com/" + faker.numerify("###########") + "/";
    }
    public static String senhaFaker() {
        return faker.internet().password();
    }
    public static String nomeFaker() {
        return faker.name().firstName() + " Teste";
    }
    public static String telefoneFaker() {
        return faker.numerify("###########");
    }
    public static String dataInicialFaker(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataInicial = dataAtual.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dataInicial.format(formatter);
    }
    public static String dataFimFaker(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataInicial = dataAtual.plusDays(20);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dataInicial.format(formatter);
    }
    public static String dataNascimentoFaker() {
        return dateFormat.format(faker.date().birthday(18, 100));
    }
    private static String usernameFaker(String nomeCompleto) {
        return nomeCompleto.toLowerCase().replace(" ", ".").replace("..", ".");
    }
    public static int gerarNumeroIntRandomico(){
        return random.nextInt(10);
    }

    public static int gerarNumeroIntAlto(){
        return random.nextInt(1000000);
    }
    public static String cpfDigitosValidos(){
        ArrayList<Integer> listaCpfDigitos = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listaCpfDigitos.add(gerarNumeroIntRandomico());
        }
        return String.valueOf(listaCpfDigitos);
    }
    public static String cpfFaker() {
        CPFFormatter formatador = new CPFFormatter();
        return formatador.format(cpfDigitosValidos());
    }
    public static String CpfFakerInvalidoComEspacoVazio() {
        String cpfInvalido = cpfFaker();
        cpfInvalido = cpfInvalido.replace(cpfInvalido.charAt(2), ' ');
        return cpfInvalido;
    }
    public static String cidadeFaker() {
        return faker.address().city();
    }
    public static String instituicaoDeEnsinoFaker() {
        return faker.educator().university();
    }
    public static String cursoFaker() {
        return faker.educator().course();
    }
    public static String estadoFaker() {
        String[] siglas = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
                "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
        Random random = new Random();
        int index = random.nextInt(siglas.length);
        return siglas[index];
    }
    public static String capitalPorSigla(String siglaEstado) {
        switch (siglaEstado.toUpperCase()) {
            case "AC":
                return "Rio Branco";
            case "AL":
                return "Maceió";
            case "AP":
                return "Macapá";
            case "AM":
                return "Manaus";
            case "BA":
                return "Salvador";
            case "CE":
                return "Fortaleza";
            case "DF":
                return "Brasília";
            case "ES":
                return "Vitória";
            case "GO":
                return "Goiânia";
            case "MA":
                return "São Luís";
            case "MT":
                return "Cuiabá";
            case "MS":
                return "Campo Grande";
            case "MG":
                return "Belo Horizonte";
            case "PA":
                return "Belém";
            case "PB":
                return "João Pessoa";
            case "PR":
                return "Curitiba";
            case "PE":
                return "Recife";
            case "PI":
                return "Teresina";
            case "RJ":
                return "Rio de Janeiro";
            case "RN":
                return "Natal";
            case "RS":
                return "Porto Alegre";
            case "RO":
                return "Porto Velho";
            case "RR":
                return "Boa Vista";
            case "SC":
                return "Florianópolis";
            case "SP":
                return "São Paulo";
            case "SE":
                return "Aracaju";
            case "TO":
                return "Palmas";
            default:
                return null;
        }
    }

}
