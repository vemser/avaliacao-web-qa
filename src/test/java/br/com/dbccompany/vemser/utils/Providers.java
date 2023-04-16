package br.com.dbccompany.vemser.utils;

import br.com.dbccompany.vemser.pages.EstagiariosPage;
import br.com.dbccompany.vemser.steps.EstagiariosStepTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Providers {
    public static Stream<Arguments> provideIdsEstagiarios() {
        //@MethodSource("br.com.dbccompany.vemser.utils.Providers#provideIdsEstagiarios") uso
        return EstagiariosStepTest.estagiariosPage.consultarIdsEstagiarios().stream().map(Arguments::of);
    }
}
