package project;

import java.util.Map;
import java.util.TreeMap;

public class MachineModel {

	private class CPU {

		private int accumulator, instructionPointer, memoryBase;

		public void incrementIP() {
			instructionPointer += 1;
		}

	}
	
	public static final Map<Integer, Instruction> INSTRUCTIONS = new TreeMap<Integer, Instruction>();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private HaltCallback callback;
	private boolean withGUI;

	public MachineModel() {
		this(false, null);
	}

	public MachineModel(boolean withGUI, HaltCallback callback) {
		this.withGUI = withGUI;
		this.callback = callback;

		// INSTRUCTION_MAP entry for "NOP"
		INSTRUCTIONS.put(0x0, arg -> {
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "LODI"
		INSTRUCTIONS.put(0x1, arg -> {
			cpu.accumulator = arg;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "LOD"
		INSTRUCTIONS.put(0x2, arg -> {
			cpu.accumulator = memory.getData(cpu.memoryBase + arg);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "LODN"
		INSTRUCTIONS.put(0x3, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			cpu.accumulator = memory.getData(cpu.memoryBase + arg1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "STO"
		INSTRUCTIONS.put(0x4, arg -> {
			memory.setData(cpu.memoryBase + arg, cpu.accumulator);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "STON"
		INSTRUCTIONS.put(0x5, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			memory.setData(cpu.memoryBase + arg1, cpu.accumulator);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "JMPR"
		INSTRUCTIONS.put(0x6, arg -> {
			cpu.instructionPointer += arg;
		});

		// INSTRUCTION_MAP entry for "JUMP"
		INSTRUCTIONS.put(0x7, arg -> {
			cpu.instructionPointer = memory.getData(cpu.memoryBase + arg);
		});

		// INSTRUCTION_MAP entry for "JUMPI"
		INSTRUCTIONS.put(0x8, arg -> {
			cpu.instructionPointer = arg;
		});

		// INSTRUCTION_MAP entry for "JMPZR"
		INSTRUCTIONS.put(0x9, arg -> {
			if (cpu.accumulator == 0) {
				cpu.instructionPointer += arg;
			} else {
				cpu.incrementIP();
			}
		});

		// INSTRUCTION_MAP entry for "JMPZ"
		INSTRUCTIONS.put(0xA, arg -> {
			if (cpu.accumulator == 0) {
				cpu.instructionPointer = memory.getData(cpu.memoryBase + arg);
			} else {
				cpu.incrementIP();
			}
		});

		// INSTRUCTION_MAP entry for "JMPZI"
		INSTRUCTIONS.put(0xB, arg -> {
			if (cpu.accumulator == 0) {
				cpu.instructionPointer = arg;
			} else {
				cpu.incrementIP();
			}
		});

		// INSTRUCTION_MAP entry for "ADDI"
		INSTRUCTIONS.put(0xC, arg -> {
			cpu.accumulator += arg;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ADD"
		INSTRUCTIONS.put(0xD, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			cpu.accumulator += arg1;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ADDN"
		INSTRUCTIONS.put(0xE, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			int arg2 = memory.getData(cpu.memoryBase + arg1);
			cpu.accumulator += arg2;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "SUBI"
		INSTRUCTIONS.put(0xF, arg -> {
			cpu.accumulator -= arg;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "SUB"
		INSTRUCTIONS.put(0x10, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			cpu.accumulator -= arg1;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "SUBN"
		INSTRUCTIONS.put(0x11, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			int arg2 = memory.getData(cpu.memoryBase + arg1);
			cpu.accumulator -= arg2;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "MULI"
		INSTRUCTIONS.put(0x12, arg -> {
			cpu.accumulator *= arg;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "MUL"
		INSTRUCTIONS.put(0x13, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			cpu.accumulator *= arg1;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "MULN"
		INSTRUCTIONS.put(0x14, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			int arg2 = memory.getData(cpu.memoryBase + arg1);
			cpu.accumulator *= arg2;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "DIVI"
		INSTRUCTIONS.put(0x15, arg -> {
			if (arg == 0)
				throw new DivideByZeroException("cannot divide by zero");
			cpu.accumulator *= arg;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "DIV"
		INSTRUCTIONS.put(0x16, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			if (arg1 == 0)
				throw new DivideByZeroException("cannot divide by zero");
			cpu.accumulator /= arg1;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "DIVN"
		INSTRUCTIONS.put(0x17, arg -> {
			int arg1 = memory.getData(cpu.memoryBase + arg);
			int arg2 = memory.getData(cpu.memoryBase + arg1);
			if (arg2 == 0)
				throw new DivideByZeroException("cannot divide by zero");
			cpu.accumulator *= arg2;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ANDI"
		INSTRUCTIONS.put(0x18, arg -> {
			if(cpu.accumulator != 0 && arg != 0) cpu.accumulator = 1;
			else cpu.accumulator = 0;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "AND"
		INSTRUCTIONS.put(0x19, arg -> {
			if(cpu.accumulator != 0 && memory.getData(cpu.memoryBase + arg) != 0) cpu.accumulator = 1;
			else cpu.accumulator = 0;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "NOT"
		INSTRUCTIONS.put(0x1A, arg -> {
			if(cpu.accumulator != 0) cpu.accumulator = 0;
			else cpu.accumulator = 1;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "CMPL"
		INSTRUCTIONS.put(0x1B, arg -> {
			if(memory.getData(cpu.memoryBase + arg) < 0) cpu.accumulator = 1;
			else cpu.accumulator = 0;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "CMPZ"
		INSTRUCTIONS.put(0x1C, arg -> {
			if(memory.getData(cpu.memoryBase + arg) == 0) cpu.accumulator = 1;
			else cpu.accumulator = 0;
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "HALT"
		INSTRUCTIONS.put(0x1F, arg -> {
			callback.halt();
		});

	}

	public Instruction get(int instrNum) {
		return INSTRUCTIONS.get(instrNum);
	}
	
	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}


}
