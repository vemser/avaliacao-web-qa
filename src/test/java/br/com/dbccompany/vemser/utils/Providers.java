package br.com.dbccompany.vemser.utils;

import br.com.dbccompany.vemser.tests.EstagiariosTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Providers {
    public static Stream<Arguments> provideIdsEstagiarios() {
        //@MethodSource("br.com.dbccompany.vemser.utils.Providers#provideIdsEstagiarios") uso
        return EstagiariosTest.estagiariosPage.consultarIdsEstagiarios().stream().map(Arguments::of);
    }
}
