package br.com.dbcompany.vemser.dataFactory;

//import br.com.dbcompany.vemser.model.ColaboradorModel;
//import br.com.dbcompany.vemser.model.TrilhaModel;
import br.com.dbcompany.vemser.model.ColaboradorModel;
import br.com.dbcompany.vemser.utils.DataFakerGenerator;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class EstagiarioDataFactory extends DataFactory {

    public static ColaboradorModel gerarEstagiarioValido(Integer idTrilha) {
        ColaboradorModel estagiario = new ColaboradorModel();
        estagiario.setIdTrilha(idTrilha);
        estagiario.setNome(DataFakerGenerator.nomeFaker());
        estagiario.setCpf(DataFakerGenerator.cpfFaker());
        estagiario.setEmailPessoal(DataFakerGenerator.emailFaker());
        estagiario.setEmailCorporativo(DataFakerGenerator.emailDbcFaker());
        estagiario.setTelefone(DataFakerGenerator.telefoneFaker());
        estagiario.setDataNascimento(DataFakerGenerator.dataNascimentoFaker());
        String uf = DataFakerGenerator.estadoValidoFaker();
        estagiario.setEstado(uf);
        estagiario.setCidade(DataFakerGenerator.capitalPorSigla(uf));
        estagiario.setCurso(DataFakerGenerator.gerarCursoValido());
        estagiario.setInstituicaoEnsino(DataFakerGenerator.gerarInstituicaoEnsinoValida());
        estagiario.setLinkedin(DataFakerGenerator.linkedinFaker());
        estagiario.setGithub(DataFakerGenerator.gitHubFaker());
        estagiario.setObservacoes(DataFakerGenerator.observacoesFaker());
        estagiario.setStatus("DISPONIVEL");
        return estagiario;
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
                Arguments.of(DataFakerGenerator.CpfFakerInvalidoComEspacoVazio()));
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

}
