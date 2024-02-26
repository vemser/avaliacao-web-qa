package br.com.dbcompany.vemser.dataFactory;

//import br.com.dbcompany.vemser.model.EstagiarioModel;
//import br.com.dbcompany.vemser.model.TrilhaModel;
import org.junit.jupiter.params.provider.Arguments;

import br.com.dbcompany.vemser.model.EstagiarioModel;

import java.util.Random;
import java.util.stream.Stream;

public class EstagiarioDataFactory extends DataFactory {
    private static String gerarUsername(String nomeCompleto) {
        return nomeCompleto.toLowerCase().replace(" ", ".").replace("..", ".");
    }

    public static String gerarCpfValido() {
        return faker.cpf().valid().replace(".", "").replace("-", "");
    }

    public static EstagiarioModel gerarEstagiarioValido(Integer idTrilha) {
        EstagiarioModel estagiario = new EstagiarioModel();
        estagiario.setIdTrilha(idTrilha);
        estagiario.setNome(gerarNomeValido());
        estagiario.setCpf(gerarCpfValido());
        estagiario.setEmailPessoal(gerarEmailPessoalValido());
        estagiario.setEmailCorporativo(gerarEmailDbcValido());
        estagiario.setTelefone(gerarTelefoneValido());
        estagiario.setDataNascimento(gerarDataNascimentoValida());
        String uf = gerarEstadoValido();
        estagiario.setEstado(uf);
        estagiario.setCidade(capitalPorSigla(uf));
        estagiario.setCurso(gerarCursoValido());
        estagiario.setInstituicaoEnsino(gerarInstituicaoEnsinoValida());
        estagiario.setLinkedin(gerarLinkedinValido());
        estagiario.setGithub(gerarGithubValido());
        estagiario.setObservacoes(gerarObservacoesValidas());
        estagiario.setStatus("DISPONIVEL");
        return estagiario;
    }

    public static String gerarNomeValido() {
        return faker.name().firstName() + " Teste";
    }

    public static String gerarEmailPessoalValido() {
        return "teste." + faker.internet().emailAddress();
    }

    public static String gerarEmailDbcValido() {
        String emailPessoal = gerarEmailPessoalValido();
        return emailPessoal.replace(emailPessoal.substring(emailPessoal.indexOf("@"), emailPessoal.length()),
                "@dbccompany.com.br");
    }

    public static String gerarTelefoneValido() {
        return faker.numerify("###########");
    }

    public static String gerarDataNascimentoValida() {
        return dateFormat.format(faker.date().birthday(18, 100));
    }

    public static String gerarEstadoValido() {
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

    public static String gerarCidadeValida() {
        return faker.address().city();
    }

    public static String gerarInstituicaoEnsinoValida() {
        return faker.educator().university();
    }

    public static String gerarCursoValido() {
        return faker.educator().course();
    }

    public static String gerarLinkedinValido() {
        return "https://teste.linkedin.com/in/" + faker.numerify("###########") + "/";
    }

    public static String gerarGithubValido() {
        return "https://teste.github.com/" + faker.numerify("###########") + "/";
    }

    public static String gerarObservacoesValidas() {
        return faker.lorem().sentence();
    }

    public static String gerarCpfComPontoEHifen() {
        return faker.cpf().valid();
    }

    public static Stream<Arguments> provideEmailsInvalidos() {
        return Stream.of(
                Arguments.of("a`" + faker.internet().emailAddress()),
                Arguments.of("a~" + faker.internet().emailAddress()),
                Arguments.of("a!" + faker.internet().emailAddress()),
                Arguments.of("a´" + faker.internet().emailAddress()),
                Arguments.of("a#" + faker.internet().emailAddress()),
                Arguments.of("a$" + faker.internet().emailAddress()),
                Arguments.of("a%" + faker.internet().emailAddress()),
                Arguments.of("aá" + faker.internet().emailAddress()),
                Arguments.of("aâ" + faker.internet().emailAddress()),
                Arguments.of("aã" + faker.internet().emailAddress()),
                Arguments.of("aé" + faker.internet().emailAddress()),
                Arguments.of("a@" + faker.internet().emailAddress()),
                Arguments.of("a.." + faker.internet().emailAddress()),
                Arguments.of(faker.internet().url()),
                Arguments.of(faker.internet().ipV4Address()),
                Arguments.of(faker.internet().ipV6Address()),
                Arguments.of(faker.internet().domainName()),
                Arguments.of(""));
    }

    public static Stream<Arguments> provideCpfInvalidos() {
        return Stream.of(
                Arguments.of(faker.numerify("a##########")),
                Arguments.of(faker.numerify("##########!")),
                Arguments.of(faker.numerify("##########à")),
                Arguments.of(faker.numerify("##########á")),
                Arguments.of(faker.numerify("##########â")),
                Arguments.of(faker.numerify("#######.####")),
                Arguments.of(faker.numerify("#######-####")),
                Arguments.of(faker.numerify("###### #####")),
                Arguments.of(faker.numerify("#          #")),
                Arguments.of(gerarCpfInvalidoComEspacoVazio()));
    }

    public static Stream<Arguments> provideNomesInvalidos() {
        return Stream.of(
                Arguments.of(faker.numerify("##########")),
                Arguments.of(faker.numerify("##### #####")),
                Arguments.of(faker.name().firstName() + "{"),
                Arguments.of(faker.name().firstName() + "}"),
                Arguments.of(faker.name().firstName() + "["),
                Arguments.of(faker.name().firstName() + "]"),
                Arguments.of(faker.name().firstName() + "<"),
                Arguments.of(faker.name().firstName() + ">"),
                Arguments.of(faker.name().firstName() + "("),
                Arguments.of(faker.name().firstName() + ")"),
                Arguments.of(faker.name().firstName() + "/"),
                Arguments.of(faker.name().firstName() + "\\"),
                Arguments.of(faker.name().firstName() + "|"),
                Arguments.of(faker.name().firstName() + "%"),
                Arguments.of(faker.name().firstName() + "!"),
                Arguments.of(faker.name().firstName() + "@"),
                Arguments.of(faker.name().firstName() + "#"),
                Arguments.of(faker.name().firstName() + "$"),
                Arguments.of(faker.name().firstName() + "*"),
                Arguments.of(faker.name().firstName() + "&"),
                Arguments.of(faker.name().nameWithMiddle() + "!"),
                Arguments.of(faker.name().nameWithMiddle() + "@"),
                Arguments.of(faker.name().nameWithMiddle() + "#"),
                Arguments.of(faker.name().nameWithMiddle() + "$"),
                Arguments.of(faker.name().nameWithMiddle() + "%"),
                Arguments.of(faker.name().nameWithMiddle() + "^"),
                Arguments.of(faker.name().nameWithMiddle() + "&"));
    }

    public static String gerarCpfInvalidoComEspacoVazio() {
        String cpfInvalido = gerarCpfValido();
        cpfInvalido = cpfInvalido.replace(cpfInvalido.charAt(2), ' ');
        return cpfInvalido;
    }
}
