# binarytree library: https://pypi.org/project/binarytree/

from binarytree import Node

root = Node(1)                  # index: 0, value: 1
root.left = Node(2)             # index: 1, value: 2
root.right = Node(3)            # index: 2, value: 3
root.left.right = Node(4)       # index: 4, value: 4
root.left.right.left = Node(5)  # index: 9, value: 5

print(root)
#
#      ____1
#     /     \
#    2__     3
#       \
#        4
#       /
#      5
#
root.pprint(index=True)
#
#       _________0-1_
#      /             \
#    1-2_____        2-3
#            \
#           _4-4
#          /
#        9-5
#
print(root[9])
# Node(5)

# Replace the node/subtree at index 4.
root[4] = Node(6, left=Node(7), right=Node(8))
root.pprint(index=True)
#
#       ______________0-1_
#      /                  \
#    1-2_____             2-3
#            \
#           _4-6_
#          /     \
#        9-7     10-8
#

# Delete the node/subtree at index 1.
del root[1]
root.pprint(index=True)
#
#    0-1_
#        \
#        2-3