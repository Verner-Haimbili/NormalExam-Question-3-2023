import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class QuestionThreeApp {

	public static void main(String[] args) {
		// Populate the list
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			list.add(i);
		}

		System.out.println("Stack Elements in same order: ");
		Stack<Integer> temp = sameOrder(list);

		int index = temp.size() - 1;
		while (!temp.isEmpty()) {
			int m = temp.pop();
			System.out.println("Element at index " + index + ": " + m);
			index -= 1;
		}

		Stack<Integer> myStack = new Stack<>();
		myStack.push(4);
		myStack.push(3);
		myStack.push(2);
		myStack.push(1);

		Stack<Integer> newStack = inverseOrder(myStack);
		System.out.println("\nReturned stack in inverse order: ");

		// Create a new stack and add elements from newStack

		int pos = newStack.size() - 1;
		while (!newStack.isEmpty()) {
			int m = newStack.pop();
			System.out.println("Element at index " + pos + ": " + m);
			pos -= 1;
		}

		System.out.println("\nOriginal stack: " + myStack);

	}

	// a) Create an algorithm that receives an input a list of integer and returns a
	// stack with the of the list in the same order.
	public static Stack<Integer> sameOrder(List<Integer> listOfIntegers) {
		Stack<Integer> stack = new Stack<>();
		for (int i = listOfIntegers.size() - 1; i >= 0; i--) {
			stack.push(listOfIntegers.get(i));
		}
		return stack;

	}

	// b) Create an algorithm that receives a stack of integers and return a new
	// stack with the elements in inverse order.
	public static Stack<Integer> inverseOrder(Stack<Integer> stack) {
		Stack<Integer> returned = new Stack<>();
		Queue<Integer> aux_queue = new LinkedList<>();

		int temp;

		while (!stack.isEmpty()) {
			temp = stack.pop();
			aux_queue.add(temp);
			returned.push(temp);
		}

		int size = aux_queue.size() - 1;

		for (int i = size; i >= 0; i--) {
			stack.push(i + 1);
			size--;
		}
		return returned;
	}
}
