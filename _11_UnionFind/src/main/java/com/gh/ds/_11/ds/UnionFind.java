package com.gh.ds._11.ds;

public interface UnionFind {

    boolean isConnected(int p, int q);

    void union(int p, int q);

    int getSize();

}
