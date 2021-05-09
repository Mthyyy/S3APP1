package menufact.plats;

/**
 * L'enum contient les differents etats possibles du plat
 */
public enum PlatEtat {
    /**
     * COMMANDE signifie que le plat est commande
     */
    COMMANDE,

    /**
     * PREPARATION signifie que le plat est en cours de preparation par le chef
     */
    PREPARATION,

    /**
     * TERMINE signifie que le chef a termine de preparer le plat
     */
    TERMINE,

    /**
     * SERVI signifie que le serveur a servi le plat au client
     */
    SERVI,

    /**
     * IMPOSSIBLE signifie que le plat ne peut pas etre prepare
     */
    IMPOSSIBLE
}
