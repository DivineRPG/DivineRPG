package divinerpg.world.arcana;


/************************************************************************
 * Disjoint set structure to make merging sets in Kruskal's algorithm more efficient.
 * Taken from an online implementation as Java does not have its own disjoint set implementation
 * File is linked here under Union-Find along with permission to use: https://www.keithschwarz.com/interesting/
 *
 * ---------------------------------------------
 *
 * File: UnionFind.java
 * Author: Keith Schwarz (htiek@cs.stanford.edu)
 *
 * An implementation of a union-find (disjoint set) data structure using
 * a disjoint-set forest.  This implementation implements the path
 * compression and union by rank optimizations, which results in very
 * efficient amortized cost for any sequence of operations.  In
 * particular, any m operations will complete in O(m a(m)), where a(m)
 * is the Ackermann inverse function.  This function grows incredibly
 * slowly, and is effectively a constant for any value of m less than
 * the number of atoms in the universe.
 *
 * Disjoint set structures can be used to implement relational
 * unification, Kruskal's MST algorithm, or Hindley-Milner type
 * inference.  They are also good at finding connected components of
 * an undirected graph.
 */

import java.util.*; // For Map, HashMap

public final class UnionFind<T> {
    /**
     * A utility struct holding an an object's parent and rank.
     */
    private static final class Link<T> {
        public T parent;
        public int rank = 0;

        /**
         * Creates a new Link object with the specified parent.
         *
         * @param parent The initial value of the parent field.
         */
        Link(T parent) {
            this.parent = parent;
        }
    }

    /**
     * A map from objects in the UnionFind structure to their associated
     * rank and parent.
     */
    private final Map<T, Link<T>> elems = new HashMap<T, Link<T>>();

    /**
     * Creates a new UnionFind structure that is initially empty.
     */
    public UnionFind() {
        // Handled implicitly
    }

    /**
     * Creates a new UnionFind structure that initially contains all of
     * the elements from the specified container.  Duplicate elements
     * will appear with multiplicity one.
     *
     * @param elems The elements to store in the UnionFind structure.
     */
    public UnionFind(Collection<? extends T> elems) {
        /* Iterate across the collection, adding each to this structure. */
        for (T elem : elems)
            add(elem);
    }

    /**
     * Inserts a new element into the UnionFind structure that initially
     * is in its own partition.  If the element already exists, this
     * function returns false.  Otherwise, it returns true.
     *
     * @param elem The element to insert.
     * @return Whether the element was successfully inserted.
     * @throws NullPointerException If elem is null.
     */
    public boolean add(T elem) {
        /* Check for null. */
        if (elem == null)
            throw new NullPointerException("UnionFind does not support null.");

        /* Check whether this entry exists; fail if it does. */
        if (elems.containsKey(elem))
            return false;

        /* Otherwise add the element as its own parent. */
        elems.put(elem, new Link<T>(elem));
        return true;
    }

    /**
     * Given an element, returns the representative element of the set
     * containing that element.  If the element is not contained in the
     * structure, this method throws a NoSuchElementException.
     *
     * @param elem The element to look up.
     * @return The representative of the set containing the element.
     * @throws NoSuchElementException If the element does not exist.
     */
    public T find(T elem) {
        /* Check whether the element exists; fail if it doesn't. */
        if (!elems.containsKey(elem))
            throw new NoSuchElementException(elem + " is not an element.");

        /* Recursively search the structure and return the result. */
        return recFind(elem);
    }

    /**
     * Given an element which is known to be in the structure, searches
     * for its representative element and returns it, applying path
     * compression at each step.
     *
     * @param elem The element to look up.
     * @return The representative of the set containing it.
     */
    private T recFind(T elem) {
        /* Get the info on this object. */
        Link<T> info = elems.get(elem);

        /* If the element is its own parent, it's the representative of its
         * class and we should say so.
         */
        if (info.parent.equals(elem))
            return elem;

        /* Otherwise, look up the parent of this element, then compress the
         * path.
         */
        info.parent = recFind(info.parent);
        return info.parent;
    }

    /**
     * Given two elements, unions together the sets containing those
     * elements.  If either element is not contained in the set,
     * throws a NoSuchElementException.
     *
     * @param one The first element to link.
     * @param two The second element to link.
     * @throws NoSuchElementException If either element does not exist.
     */
    public void union(T one, T two) {
        /* Get the link info for the parents.  This also handles the exception
         * guarantee.
         */
        Link<T> oneLink = elems.get(find(one));
        Link<T> twoLink = elems.get(find(two));

        /* If these are the same object, we're done. */
        if (oneLink == twoLink) return;

        /* Otherwise, link the two.  We'll do a union-by-rank, where the parent
         * with the lower rank will merge with the parent with higher rank.
         */
        if (oneLink.rank > twoLink.rank) {
            /* Since each parent must link to itself, the value of oneLink.parent
             * is the representative of one.
             */
            twoLink.parent = oneLink.parent;
        } else if (oneLink.rank < twoLink.rank) {
            /* Same logic as above. */
            oneLink.parent = twoLink.parent;
        } else {
            /* Arbitrarily wire one to be the parent of two. */
            twoLink.parent = oneLink.parent;

            /* Bump up the representative of one to the next rank. */
            oneLink.rank++;
        }
    }
}