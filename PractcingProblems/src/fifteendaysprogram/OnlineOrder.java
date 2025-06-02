package fifteendaysprogram;

public class OnlineOrder {

	private OfflineOrder offlineOrder;

	public OnlineOrder() {
		this.offlineOrder = new OfflineOrder(); // Creating dependency directly
	}

	public void handleOrder() {
		offlineOrder.processOrder();
		System.out.println("Handling online order...");
	}

}
