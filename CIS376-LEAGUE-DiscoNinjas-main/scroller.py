import league
import pygame as pg

class Scroller(league.UGameObject):
    def __init__(self, engine, scene, player, spawn_x, spawn_y):
        super().__init__()
        self.scene = scene
        self.engine = engine
        self.player = player
        self.spawn_x = spawn_x
        self.spawn_y = spawn_y
        self.viewport_min = 0
        self.viewport_max = engine.height

    def get_y(self):
        return self.spawn_y
    def get_x(self):
        return self.spawn_x
    
    def update(self):

        if self.player.rect.y > (self.viewport_max - self.viewport_min)/2 and self.viewport_max < 1600:
            for obj in self.scene.drawables:
                obj.y -= 4
                obj.rect.y -= 4
                self.spawn_x += 4
                self.spawn_y += 4
            self.viewport_max += 4
            self.viewport_min += 4
        
        if self.player.rect.y < (self.viewport_max - self.viewport_min)/2 and self.viewport_min > 0:
            for obj in self.scene.drawables:
                obj.y += 4
                obj.rect.y += 4
                self.spawn_x += 4
                self.spawn_y += 4
            self.viewport_max -= 4
            self.viewport_min -= 4
