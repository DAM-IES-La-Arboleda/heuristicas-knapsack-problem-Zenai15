package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import core.Item;
import core.KnapsackSolver;

public class BaseSolver implements KnapsackSolver {

	@Override
	public List<Item> solve(List<Item> items, double capacity) {
		List<Item> selectedItems = new ArrayList<>();
		double currentWeight = 0;
		TreeMap<Double, Item> lista = new TreeMap<>();

		for (Item item : items) {
			lista.put(item.value() / item.weight(), item);
		}

		while (currentWeight <= capacity) {
			selectedItems.add(lista.get(lista.pollFirstEntry()));
		}

		return selectedItems;
	}
}
