import {useState} from "react";
import {bejelentkezes} from "../api.js";

export default function LoginPage({onSikeresBelepes}) {
    const [felhasznalonev, setFelhasznalonev] = useState('')
    const [jelszo, setJelszo] = useState('')
    const [hiba, setHiba] = useState('')
    const [tolt, setTolt] = useState(false)

    async function kuldes(esemeny) {
        esemeny.preventDefault()
        setHiba('')
        setTolt(true)
        try{
            const token = await bejelentkezes(felhasznalonev,jelszo)
            onSikeresBelepes(token)
        } catch (e){
            setHiba(e.message)
        } finally {
            setTolt(false)
        }
    }

    return (
        <form className="kartya" onSubmit={kuldes}>
            <h1>Bejelentkezés</h1>

            <label>
                Felhasználónév
                <input
                    value={felhasznalonev}
                    onChange={(e) => setFelhasznalonev(e.target.value)}
                    required
                />
            </label>

            <label>
                Jelszó
                <input
                    type="password"
                    value={jelszo}
                    onChange={(e) => setJelszo(e.target.value)}
                    required
                />
            </label>

            <button type="submit" disabled={tolt}>
                {tolt ? 'Belépés...' : 'Belépés'}
            </button>

            {hiba && <p className="hiba">{hiba}</p> }
        </form>
    )

}