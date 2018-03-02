public interface Collidable
{
    /**
     * Checks collisions with other CollidableObjects.
     * @param other: the object to check collision with.
     */
    public void checkCollision(CollidableObject other);
}
