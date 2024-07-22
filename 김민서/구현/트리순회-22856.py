# 유사 중위 순회를 하면서 이동한 횟수
# 순회의 시작은 트리의 루트고, 순회의 끝은 중위 순회 시 마지막 노드다.

from sys import setrecursionlimit
setrecursionlimit(10**8)

class Node:
    def __init__(self, current_node, left_node, right_node):
        self.current_node = current_node
        self.left_node = left_node
        self.right_node = right_node

def inorder(node, tree, inorder_list):
    if node.left_node != -1:
        inorder(tree[node.left_node], tree, inorder_list)
    inorder_list.append(node.current_node)
    if node.right_node != -1:
        inorder(tree[node.right_node], tree, inorder_list)

def modified_inorder(node, tree, inorder_list):
    global moves

    if node.left_node != -1:
        modified_inorder(tree[node.left_node], tree, inorder_list)
        moves += 1

    if node.current_node == inorder_list[-1]: # 중위순회의 마지막 노드와 같다면 종료
        print(moves)
        exit(0)

    moves += 1

    if node.right_node != -1:
        modified_inorder(tree[node.right_node], tree, inorder_list)
        moves += 1

def main():
    global moves
    moves = 0
    inorder_list = []
    n = int(input())
    tree = {}

    for _ in range(n):
        current_node, left_node, right_node = map(int, input().split())
        tree[current_node] = Node(current_node, left_node, right_node)
    
    inorder(tree[1], tree, inorder_list)
    modified_inorder(tree[1], tree, inorder_list)

if __name__ == "__main__":
    main()