// !WITH_NEW_INFERENCE
// !CHECK_TYPE
open class Outer<E> {
    inner open class Inner<F> {
        inner class Inner2<D> {

        }
    }
}

class DerivedOuter : Outer<String>() {
    inner class DerivedInner : <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER, NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!>Inner<!><Int>() {
        fun foo(): Inner2<Char> = null!!
    }
}

fun foo() {
    DerivedOuter().DerivedInner().foo() checkType { _<Outer<String>.Inner<Int>.Inner2<Char>>() }
}
