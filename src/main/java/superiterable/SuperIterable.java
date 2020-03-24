package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> self) {
    this.self = self;
  }

  public <F> SuperIterable<F> map(Function<E, F> op) {
    List<F> soFar = new ArrayList<>();

//    self.forEach(e -> soFar.add(op.apply(e)));

    for (E e : self) {
      soFar.add(op.apply(e));
    }

    return new SuperIterable<>(soFar);
  }
  public void forEvery(Consumer<E> op) {
    for (E e : self) {
      op.accept(e);
    }
  }
  public Iterator<E> iterator() {
    return self.iterator();
  }
}
