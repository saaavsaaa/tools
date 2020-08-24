package date.iterator.tools;

public enum  Printer {

    INSTANCE;

    private boolean willPrint;

    private int in = 0;

    public void runAt() {
        in++;
    }

    public void printIn(final String title) {
        System.out.println(title + " in:" + in);
        in = 0;
    }

    public void printArray(final int[] list) {
        printArray(0 , list.length, list);
    }

    public void printArray(final int low, final int high, final int[] list) {
        if (!willPrint) {
            return;
        }

        System.out.println("---------------------------------------------------");
        int index = low;
        while (index < high) {
            System.out.println(list[index]);
            index++;
        }
        System.out.println("---------------------------------------------------");
        setWillPrint(false);
    }

    public <T> void printArray(final T[] list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public void setWillPrint(boolean willPrint) {
        this.willPrint = willPrint;
    }
}
