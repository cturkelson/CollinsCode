from pytmx.util_pygame import load_pygame
import league
import ball
import projectiles
import pygame
import pytmx
from controller import GameController
from scroller import Scroller
from win import WinController
from lose import LoseController

level_one = league.Scene("Level One")
level_one.set_fps(60)
# level_two = league.Scene("You Win")
# level_two.set_fps(60)
engine = league.Engine("Disco Ninjas blue ball          z", level_one)
engine.init_pygame()

screen = pygame.display.set_mode((800, 800))
map = load_pygame('Map/baseMap.tmx')


for x, y, image in map.layers[0].tiles():
    tmp = league.DGameObject()
    tmp._layer = map.layers[0].tiles()
    tmp.image = image
    tmp.rect = tmp.image.get_rect()
    tmp.rect.x = x * map.tilewidth
    tmp.rect.y = y * map.tileheight
    level_one.drawables.append(tmp)

for x, y, image in map.layers[1].tiles():
    tmp = league.DGameObject()
    tmp._layer = map.layers[1].tiles()
    tmp.image = image
    tmp.rect = tmp.image.get_rect()
    tmp.rect.x = x * map.tilewidth
    tmp.rect.y = y * map.tileheight
    tmp.type = "platform"
    level_one.drawables.append(tmp)
    level_one.collideables.append(tmp)

torch_count = 0
for x, y, image in map.layers[2].tiles():
    torch_count += 1
    tmp = league.DUGameObject()
    tmp._layer = map.layers[2].tiles()
    tmp.image = image
    tmp.rect = tmp.image.get_rect()
    tmp.rect.x = x * map.tilewidth
    tmp.rect.y = y * map.tileheight
    tmp.type = "torch"
    level_one.drawables.append(tmp)
    level_one.updateables.append(tmp)
    level_one.collideables.append(tmp)

for x, y, image in map.layers[3].tiles():
    tmp = league.DUGameObject()
    tmp._layer = map.layers[3].tiles()
    tmp.image = image
    tmp.rect = tmp.image.get_rect()
    tmp.rect.x = x * map.tilewidth
    tmp.rect.y = y * map.tileheight
    tmp.type = "turrent"
    level_one.drawables.append(tmp)

for x, y, image in map.layers[4].tiles():
    tmp = projectiles.Enemy(engine, level_one)
    tmp._layer = map.layers[4].tiles()
    tmp.image = image
    tmp.rect = tmp.image.get_rect()
    tmp.x = x
    tmp.y = y * 32
    tmp.set_x(x)
    tmp.rect.x = x 
    tmp.rect.y = y 
    tmp.type = "shots"
    level_one.drawables.append(tmp)
    level_one.updateables.append(tmp)
    level_one.collideables.append(tmp)

for x, y, image in map.layers[5].tiles():
    tmp = league.DUGameObject()
    tmp._layer = map.layers[5].tiles()
    tmp.image = image
    tmp.rect = tmp.image.get_rect()
    tmp.rect.x = x * map.tilewidth
    tmp.rect.y = y * map.tileheight
    tmp.type = "spawn"
    spawn_x = tmp.rect.x
    spawn_y = tmp.rect.y
    level_one.drawables.append(tmp)
    level_one.updateables.append(tmp)
    level_one.collideables.append(tmp)

controller = GameController(engine, torch_count, screen)
level_one.updateables.append(controller)
level_one.drawables.append(controller)
player = ball.Ball(engine, level_one, controller, spawn_x, spawn_y)
level_one.drawables.append(player)
level_one.updateables.append(player)
scroller = Scroller(engine, level_one, player, spawn_x, spawn_y)
level_one.updateables.append(scroller)

engine.run()
