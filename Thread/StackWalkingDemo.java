package Thread;

import java.lang.StackWalker.StackFrame;
import java.util.*;
import java.util.stream.*;

public class StackWalkingDemo {
    public static void main(String[] args) {
        new StackWalkingDemo().walk();
    }
    private void walk() {
        new Walker1().walk();
    }
    private class Walker1 {
        public void walk() {
            new Walker2().walk();
        }
    }
    private class Walker2 {
        public void walk() {
            FirstMethod();
        }
        void FirstMethod() {
            SecondMethod();
        }
        void SecondMethod() {
            StackWalker stackWalker = StackWalker.getInstance(Set.of(StackWalker.
                    Option.RETAIN_CLASS_REFERENCE, StackWalker.Option.SHOW_HIDDEN_FRAMES),16);
            Stream<StackFrame> stackStream = StackWalker.getInstance().walk(f -> f);
            List<String> stacks = walkAllStackframes();
            System.out.println("Number of StackFrames: " + stacks.size());
            System.out.println("*Walk through all StackFrames*");
            System.out.println(stacks);
            System.out.println("*Skip some StackFrames*");
            List<String> stacksAfterSkip = walkSomeStackframes(2);
            System.out.println("*Number of StackFrames remaining: " + stacksAfterSkip.size());
            System.out.println(stacksAfterSkip);
        }
        private List<String> walkAllStackframes() {
            return StackWalker.getInstance().walk(s -> s.map(frame -> "\n" +
                    frame.getClassName() + "/" + frame.getMethodName()).
                    collect(Collectors.toList()));
        }
        private List<String> walkSomeStackframes(int numberOfFrames) {
            return StackWalker.getInstance().walk(s -> s.map(frame -> "\n" +
                            frame.getClassName() + "/" + frame.getMethodName()).
                    skip(numberOfFrames).collect(Collectors.toList()));
        }
    }
}
