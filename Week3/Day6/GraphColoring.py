import unittest


class GNode:
    def __init__(self, label):
        self.label = label
        self.neighb = set()
        self.color = None


def color_graph(graph, colors):
    # Create a valid coloring for the graph

    for i in graph:
        if i in i.neighb:
            assert (), "Exception"
        colors_list = neighbor_color(i)
        for c in colors:
            if c not in colors_list:
                i.color = c
                print(i.label + "-" + i.color + "::::", end="")
                break

        # print()
    print("----------------")



def neighbor_color(node):
    l = []
    for i in node.neighb:
        l.append(i.color)

    return l


# Tests

class Test(unittest.TestCase):
    def setUp(self):
        self.colors = frozenset([
            'red',
            'green',
            'blue',
            'orange',
            'yellow',
            'white',
        ])

    def assertGraphColoring(self, graph, colors):
        self.assertGraphHasColors(graph, colors)
        self.assertGraphColorLimit(graph)
        for node in graph:
            self.assertNodeUniqueColor(node)

    def assertGraphHasColors(self, graph, colors):
        for node in graph:
            msg = 'Node %r color %r not in %r' % (node.label, node.color, colors)
            self.assertIn(node.color, colors, msg=msg)

    def assertGraphColorLimit(self, graph):
        max_degree = 0
        colors_found = set()
        for node in graph:
            degree = len(node.neighb)
            max_degree = max(degree, max_degree)
            colors_found.add(node.color)
        max_colors = max_degree + 1
        used_colors = len(colors_found)
        msg = 'Used %d colors and expected %d at most' % (used_colors, max_colors)
        self.assertLessEqual(used_colors, max_colors, msg=msg)

    def assertNodeUniqueColor(self, node):
        for adjacent in node.neighb:
            msg = 'Adjacent nodes %r and %r have the same color %r' % (
                node.label,
                adjacent.label,
                node.color,
            )
            self.assertNotEqual(node.color, adjacent.color, msg=msg)

    def test_line_graph(self):
        node_a = GNode('a')
        node_b = GNode('b')
        node_c = GNode('c')
        node_d = GNode('d')

        node_a.neighb.add(node_b)
        node_b.neighb.add(node_a)
        node_b.neighb.add(node_c)
        node_c.neighb.add(node_b)
        node_c.neighb.add(node_d)
        node_d.neighb.add(node_c)

        graph = [node_a, node_b, node_c, node_d]
        tampered_colors = list(self.colors)
        color_graph(graph, tampered_colors)
        self.assertGraphColoring(graph, self.colors)

    def test_separate_graph(self):
        node_a = GNode('a')
        node_b = GNode('b')
        node_c = GNode('c')
        node_d = GNode('d')

        node_a.neighb.add(node_b)
        node_b.neighb.add(node_a)
        node_c.neighb.add(node_d)
        node_d.neighb.add(node_c)

        graph = [node_a, node_b, node_c, node_d]
        tampered_colors = list(self.colors)
        color_graph(graph, tampered_colors)
        self.assertGraphColoring(graph, self.colors)

    def test_triangle_graph(self):
        node_a = GNode('a')
        node_b = GNode('b')
        node_c = GNode('c')

        node_a.neighb.add(node_b)
        node_a.neighb.add(node_c)
        node_b.neighb.add(node_a)
        node_b.neighb.add(node_c)
        node_c.neighb.add(node_a)
        node_c.neighb.add(node_b)

        graph = [node_a, node_b, node_c]
        tampered_colors = list(self.colors)
        color_graph(graph, tampered_colors)
        self.assertGraphColoring(graph, self.colors)

    def test_envelope_graph(self):
        node_a = GNode('a')
        node_b = GNode('b')
        node_c = GNode('c')
        node_d = GNode('d')
        node_e = GNode('e')

        node_a.neighb.add(node_b)
        node_a.neighb.add(node_c)
        node_b.neighb.add(node_a)
        node_b.neighb.add(node_c)
        node_b.neighb.add(node_d)
        node_b.neighb.add(node_e)
        node_c.neighb.add(node_a)
        node_c.neighb.add(node_b)
        node_c.neighb.add(node_d)
        node_c.neighb.add(node_e)
        node_d.neighb.add(node_b)
        node_d.neighb.add(node_c)
        node_d.neighb.add(node_e)
        node_e.neighb.add(node_b)
        node_e.neighb.add(node_c)
        node_e.neighb.add(node_d)

        graph = [node_a, node_b, node_c, node_d, node_e]
        tampered_colors = list(self.colors)
        color_graph(graph, tampered_colors)
        self.assertGraphColoring(graph, self.colors)

    def test_loop_graph(self):
        node_a = GNode('a')

        node_a.neighb.add(node_a)

        graph = [node_a]
        tampered_colors = list(self.colors)
        with self.assertRaises(Exception):
            color_graph(graph, tampered_colors)


unittest.main(verbosity=2)
