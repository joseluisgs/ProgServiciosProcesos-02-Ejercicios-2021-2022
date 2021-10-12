package TDA;

import java.util.Collection;

/**
 * Contrato que toda Cola debe cumplir
 */
public interface ICola<E> extends Collection<E> {

    void encolar(E item);
    E desencolar();
}
