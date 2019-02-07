from collections import defaultdict
import csv

class Station:
  def __init__(self):
    self.stationno = 0
    self.line = ""
    self.name = ""

  def setLine(self, line):
    self.line = line

  def setStationNo(self, stationno):
    self.stationno = stationno

  def setName(self, name):
    self.name = name

  def getName(self):
    return self.name

  def getLine(self):
    return self.line

  def getStationNo(self):
    return self.stationno

class Graph:
  def __init__(self):
    self.nodes = set()
    self.stations = set()
    self.edges = defaultdict(list)
    self.optimal = {}
    self.distances = {}

  def addStationName(self, value):
    self.stations.add(value)

  def add_node(self, value):
    self.nodes.add(value)

  def add_edge(self, from_node, to_node, distance):
    self.edges[from_node].append(to_node)
    self.edges[to_node].append(from_node)
    self.distances[(from_node, to_node)] = distance
    self.distances[(to_node, from_node)] = distance

  def set_optimal(self, to_node, from_node):
    self.optimal[to_node] = from_node;

  def walkOptimal(self, from_node):
    if from_node in self.optimal:
      return self.optimal[from_node]
    return

  def findNode(self, originName, destName):
    originAddr = None
    destAddr = None

    for node in self.nodes:
      if originAddr is None and node.getName() == originName:
        originAddr = node
      elif destAddr is None and node.getName() == destName:
        destAddr = node
      elif originAddr is not None and destAddr is not None:
        break

    return originAddr, destAddr

  def setTransfer(self):
    for station in self.stations:
      duplicates = [];
      for node in self.nodes:
        if node.getName() == station:
          duplicates.append(node)

      for duplicate in duplicates:
        for duplicate2 in duplicates:
          self.add_edge(duplicate, duplicate2, 0)

def dijsktra(graph, initial, dest):
  visited = {initial: 0}
  path = {}

  nodes = set(graph.nodes)

  while nodes: 
    min_node = None
    for node in nodes:
      if node in visited:
        if min_node is None:
          min_node = node
        elif visited[node] < visited[min_node]:
          min_node = node

    if min_node is None:
      break

    nodes.remove(min_node)
    current_weight = visited[min_node]

    for edge in graph.edges[min_node]:
      weight = current_weight + graph.distances[(min_node, edge)]
      if edge not in visited or weight < visited[edge]:
        visited[edge] = weight
        graph.set_optimal(edge, min_node)
        """
        path[edge] = min_node
        """

  path = graph.walkOptimal(dest)
  stack = [];

  dest_temp = dest

  stack.append(dest)

  while dest_temp and path:
    stack.append(path)
    dest_temp = path
    path = graph.walkOptimal(dest_temp)

  path = ""

  while stack:
    item = stack.pop()
    path += item.getLine() + "호선 " + item.getName() + "역"

  return visited, path, visited[dest]

g = Graph()
weight_transfer = 0

with open('subway.csv', newline='') as csvfile:
  spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
  node = None
  for row in spamreader:
    prev = node
    node = Station()
    node.setName(row[2])
    node.setLine(row[1])
    node.setStationNo(int(row[0]))
    g.add_node(node)
    g.addStationName(row[2])
    if prev is not None and prev.getLine() == node.getLine():
      g.add_edge(prev, node, int(row[3]))

g.setTransfer()

origin = input("출발지를 입력하세요 : ")
dest = input("도착지를 입력하세요 : ")

ret = g.findNode(origin, dest)

print("출발지 : ", ret[0].getName(), "역", ret[0].getLine(), "호선")
print("도착지 : ", ret[1].getName(), "역", ret[1].getLine(), "호선")

print(dijsktra(g, ret[0], ret[1]))