package dataFactory;

import org.junit.jupiter.params.provider.Arguments;

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
}
