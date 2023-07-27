package com.example.bmpcollect;


public final class ltwo<A, B, C>
{
    public final A a;
    public final B b;
    public final C c;

    public ltwo(final A a, final B b, final C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof l)) {
            return false;
        }
        final l l = (l)o;
        return l.a.equals(this.a) && l.b.equals(this.b);
    }

    @Override
    public final int hashCode() {
        final A a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = a.hashCode();
        }
        final B b = this.b;
        int hashCode3;
        if (b == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = b.hashCode();
        }
        final C c = this.c;
        if (c != null) {
            hashCode = c.hashCode();
        }
        return hashCode2 ^ hashCode3 ^ hashCode;
    }
}
