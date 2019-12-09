package facade;

class CPU {
    public void freeze() {
        System.out.println("CPU freeze");
    }
    public void jump(long position) {
        System.out.println("CPU jump to position " + position);
    }
    public void execute() {
        System.out.println("CPU execute");
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("Read storage from " + lba + " " + size + "bytes");
        String loadData = "Ladataan...";
        byte[] b = loadData.getBytes();
        return b;
    }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("RAM read data " + data + " from position " + position + ":");
        for (int i = 0; i < data.length; i++) {
            System.out.println('\t' + data[i]);
        }
    }
}

/* Facade */

class ComputerFacade {
    private final CPU processor;
    private final Memory ram;
    private final HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(2L, hd.read(2442, 11));
        processor.jump(2L);
        processor.execute();
    }
}

/* Client */

class You {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}