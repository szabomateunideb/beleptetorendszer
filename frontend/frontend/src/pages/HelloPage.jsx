import {useEffect, useState} from "react";
import {helloLekeres} from "../api.js";

export default function HelloPage({ token, onKilepes}) {
    const [uzenet, setUzenet] = useState('Betöltés...')
    useEffect(() => {
        helloLekeres(token)
            .then((szoveg) => setUzenet(szoveg))
            .catch(() => setUzenet('Lejárt vagy érvénytelen token'))

    }, [token])

    return (
        <div className="kartya">
            <h1>{uzenet}</h1>
            <button onClick={onKilepes}>Kilepes</button>
        </div>
    )
}