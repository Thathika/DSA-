class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;

        // Create copy of each node
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Connect next and random pointers
        current = head;

        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }
}