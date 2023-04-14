package dataFactory;

import model.CandidatosModel;
import org.junit.jupiter.params.provider.Arguments;
import service.CaptacaoService;

import java.util.List;
import java.util.stream.Stream;

public class DataFactory {
    private static final String USUARIO_VALIDO = System.getenv("DBC_USER");
    private static final String SENHA_VALIDO = System.getenv("DBC_PASSWORD");
    public static Stream<Arguments> provideLoginsInvalidos() {
        return Stream.of(
                Arguments.of(USUARIO_VALIDO, "senha"),
                Arguments.of("usuario", SENHA_VALIDO),
                Arguments.of("usuario", "senha"),
                Arguments.of("", SENHA_VALIDO),
                Arguments.of(USUARIO_VALIDO, ""),
                Arguments.of("", "")
        );
    }
    public static void consultarCanditadosEdicaoAtual() {
        String nomeEdicaoAtual = CaptacaoService.consultarEdicaoAtual();
        List<CandidatosModel> response = CaptacaoService
                .consultarListaDeCandidatos(0, 20, "edicao", 1)
                    .extract()
                    .jsonPath()
                    .getList("elementos", CandidatosModel.class)
        ;
        response.stream()
                .filter(candidatosModel ->
                    candidatosModel.getEdicao().getNome().equals(nomeEdicaoAtual)
//                            &&
//                        CaptacaoService.consultarSeCandidatoEstaNaEdicaoAtual(candidatosModel.getCpf())
                )
                .map((candidatosModel) ->
                        {
                            System.out.println("\"%s\", \"%s\", \"%s\""
                                    .formatted(
                                            candidatosModel.getCpf().replace(".", "").replace("-", ""),
                                            candidatosModel.getNome(),
                                            candidatosModel.getEmail()
                                    )
                            );
                            return null;
                        }
                )
                .toArray()
        ;
    }

//        return
////        String[][] candidatos =
//                response.stream()
//                .filter(candidatosModel ->
//                    candidatosModel.getEdicao().getNome().equals(nomeEdicaoAtual) &&
//                        CaptacaoService.consultarSeCandidatoEstaNaEdicaoAtual(candidatosModel.getCpf())
//                )
//                .map(candidatosModel ->
//                    new String[]
//                        {
//                            candidatosModel.getCpf().replace(".", "").replace("-", ""),
//                            candidatosModel.getNome(),
//                            candidatosModel.getEmail()
//                        }
//                )
//                .toArray(String[][]::new);
    public static Stream<Arguments> provideCanditadosEdicaoAtual() {
        return Stream.of(
                Arguments.of("77515675039", "FREDERICO CASTELO DA NÓBREGA", "mariacecilia.caldas@yahoo.com"),
                Arguments.of("17318662325", "REBECA MANGUEIRA DA CRUZ", "dalila.martim@yahoo.com"),
                Arguments.of("68426083765", "JOSÉ ASSUMPÇÃO DA FONTOURA", "karla.xavier@hotmail.com"),
                Arguments.of("99573068630", "PATRÍCIA ADRIANA NUNES", "patricia_adriana_nunes@chalu.com.br"),
                Arguments.of("86118041040", "ISABELLA MANGUEIRA DA SILVA", "bruna.roriz@yahoo.com"),
                Arguments.of("86700148405", "SR ISAAC DA FONTOURA GERALDES", "sophie.guedes@bol.com.br"),
                Arguments.of("58455315865", "KLÉBER DORNELES VIDAL JR", "isadora.dasneves@gmail.com"),
                Arguments.of("91647289866", "TESTE PARA VER SE VAI DOCX", "ayla.rebeca.dasneves@gmaill.com"),
                Arguments.of("77565383074", "SR FRANCISCA CABREIRA ALBUQUERQUE", "oliver.regueira@gmail.com"),
                Arguments.of("06178631642", "BERNARDO VIEIRA NOVAES", "igor.lessa@hotmail.com"),
                Arguments.of("45267163325", "MORGANA FONTINHAS TELES", "pedromiguel.velasques@gmail.com"),
                Arguments.of("24263337310", "ALLANA MUNIZ AMBRÓSIO", "caua.beltrao@hotmail.com"),
                Arguments.of("85153684806", "ALICE GABEIRA AROEIRA", "mercia.nogueira@live.com"),
                Arguments.of("01571474447", "SR MARCELO GENTIL ARRIAGA", "malu.resende@gmail.com"),
                Arguments.of("68313385693", "LUCAS GABRIEL GOULART PEIXOTO", "mariasophia.teixeira@yahoo.com"),
                Arguments.of("31842721097", "DRA WARLEY MOREIRA RIBAS", "washington.assumpcao@yahoo.com")
        );
    }
    public static Stream<Arguments> provideCpfNaoCadastrado() {
        return Stream.of(
                Arguments.of("15880472884"),
                Arguments.of("53332231901")
        );
    }
}
